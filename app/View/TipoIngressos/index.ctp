<div class="col-md-8">
	<h2><?php echo __('Tipo Ingressos'); ?></h2>
	<table class="table  table-hover" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
			<th><?php echo $this->Paginator->sort('id'); ?></th>
			<th><?php echo $this->Paginator->sort('designacao'); ?></th>
			<th class="actions"><?php echo __('Actions'); ?></th>
	</tr>
	</thead>
	<tbody>
	<?php foreach ($tipoIngressos as $tipoIngresso): ?>
	<tr>
		<td><?php echo h($tipoIngresso['TipoIngresso']['id']); ?>&nbsp;</td>
		<td><?php echo h($tipoIngresso['TipoIngresso']['designacao']); ?>&nbsp;</td>
		<td class="actions">
			<?php echo $this->Html->link("<span class='glyphicon glyphicon-eye-open'></span> Visualizar", array('action' => 'view', $tipoIngresso['TipoIngresso']['id']), array('escape' => false, 'class' => 'btn btn-primary')); ?>
			<?php echo $this->Html->link("<span class='glyphicon glyphicon-edit'></span> Modificar", array('action' => 'edit', $tipoIngresso['TipoIngresso']['id']), array('escape' => false, 'class' => 'btn btn-success')); ?>
			<?php echo $this->Form->postLink("<span class='glyphicon glyphicon-trash'></span> Remover", array('action' => 'delete', $tipoIngresso['TipoIngresso']['id']), array('class' => 'btn btn-danger', 'escape' => false, 'confirm' => __('Are you sure you want to delete # %s?', $tipoIngresso['TipoIngresso']['id']))); ?>
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
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('New Tipo Ingresso'), array('action' => 'add')); ?></li>
	</ul>
</div>
