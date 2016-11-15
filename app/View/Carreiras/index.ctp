<div class="col-md-8">
	<h4 class="settings-font-color"><span style="font-size: 24px;" class="glyphicon glyphicon-briefcase"></span> <?php echo __('Carreiras disponiveis no sistema'); ?></h4>
	<a href="">
		<span class="glyphicon glyphicon-print"></span>
		Imprimir
	</a>
	<div class="well">
		Alguma informacao relacionada com a configuracao inserccao de novas carreiras
	</div>
	<table class="table table-striped" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
			<th><?php echo $this->Paginator->sort('id'); ?></th>
			<th><?php echo $this->Paginator->sort('nome'); ?></th>
			<th class="actions"><?php echo __('Actions'); ?></th>
	</tr>
	</thead>
	<tbody>
	<?php foreach ($carreiras as $carreira): ?>
	<tr>
		<td><?php echo h($carreira['Carreira']['id']); ?>&nbsp;</td>
		<td><?php echo h($carreira['Carreira']['nome']); ?>&nbsp;</td>
		<td class="actions">
			<?php echo $this->Html->link("<span class='glyphicon glyphicon-eye-open'></span> Visualizar", array('action' => 'view', $carreira['Carreira']['id']), array('escape' => false)); ?>
			<?php echo $this->Html->link("<span class='glyphicon glyphicon-edit'></span> Editar", array('action' => 'edit', $carreira['Carreira']['id']), array('escape' => false)); ?>
			<?php echo $this->Form->postLink("<span class='glyphicon glyphicon-trash'></span> Remover", array('action' => 'delete', $carreira['Carreira']['id']), array( 'escape' => false, 'confirm' => __('Are you sure you want to delete # %s?', $carreira['Carreira']['id']))); ?>
		</td>
	</tr>
<?php endforeach; ?>
	</tbody>
	</table>
	<p>
	<?php
	echo $this->Paginator->counter(array(
		'format' => __('Page {:page} of {:pages}, showing {:current} records out of {:count} total, starting on record {:start}, ending on {:end}')
	));
	?>	</p>
	<div class="paging">
	<?php
		echo $this->Paginator->prev('< ' . __('previous'), array(), null, array('class' => 'prev disabled'));
		echo $this->Paginator->numbers(array('separator' => ''));
		echo $this->Paginator->next(__('next') . ' >', array(), null, array('class' => 'next disabled'));
	?>
	</div>
</div>
<div class="col-md-4">
	<div class="list-group">
	  <a href="#" class="list-group-item active">
	    <h4><span class="glyphicon glyphicon-menu-left"></span> <?php echo __('Menu'); ?></h4>
	  </a>
	  <a href="#" class="list-group-item"> <span class="glyphicon glyphicon-cog"></span> Configuracoes</a>
	  <a href="#" class="list-group-item">Morbi leo risus</a>
	  <a href="#" class="list-group-item">Porta ac consectetur ac</a>
	  <a href="#" class="list-group-item">Vestibulum at eros</a>
		<?php echo $this->Html->link(__('New Carreira'), array('action' => 'add'), array('class' => 'list-group-item')); ?>
	</div>
</div>
