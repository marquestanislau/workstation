<div class="col-md-6">
	<h4 class="settings-font-color"><span class="glyphicon glyphicon-file"></span><?php echo __('Sectores'); ?></h4>
        <table class="table table-hover" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
			<th><?php echo $this->Paginator->sort('id'); ?></th>
			<th><?php echo $this->Paginator->sort('designacao'); ?></th>
			<th><?php echo $this->Paginator->sort('delegacao_id'); ?></th>
			<th class="actions"><?php echo __('Actions'); ?></th>
	</tr>
	</thead>
	<tbody>
	<?php foreach ($sectores as $sectore): ?>
	<tr>
		<td><?php echo h($sectore['Sectore']['id']); ?>&nbsp;</td>
		<td><?php echo h($sectore['Sectore']['designacao']); ?>&nbsp;</td>
		<td>
			<?php echo $this->Html->link($sectore['Delegacao']['nome'], array('controller' => 'delegacaos', 'action' => 'view', $sectore['Delegacao']['id'])); ?>
		</td>
		<td class="actions">
			<?php echo $this->Html->link(__('View'), array('action' => 'view', $sectore['Sectore']['id'])); ?>
			<?php echo $this->Html->link(__('Edit'), array('action' => 'edit', $sectore['Sectore']['id'])); ?>
			<?php echo $this->Form->postLink(__('Delete'), array('action' => 'delete', $sectore['Sectore']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $sectore['Sectore']['id']))); ?>
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
		<a class="list-group-item active" href="">
			<h3><?php echo __('Menu'); ?></h3>	
		</a>
		<?php echo $this->Html->link("<span class='glyphicon glyphicon-plus'></span> Novo sector", array('action' => 'add'), array('class' => 'list-group-item', 'escape' => false)); ?>
		<?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Listas das delega&ccedil;&otilde;s", array('controller' => 'delegacaos', 'action' => 'index'), array('class' => 'list-group-item', 'escape' => false)); ?>
		<?php echo $this->Html->link("<span class='glyphicon glyphicon-map-marker'></span> Nova delega&ccedil;&atilde;o", array('controller' => 'delegacaos', 'action' => 'add'), array('class' => 'list-group-item', 'escape' => false)); ?>
	</div>
	<div class="input-group">
		<input type="text" class="form-control" placeholder="Insira o nome do sector..." >
		<span class="input-group-btn">
			<button class="btn btn-default">
				<span class="glyphicon glyphicon-search"></span> Procurar
			</button>
		</span>
	</div>
</div>
