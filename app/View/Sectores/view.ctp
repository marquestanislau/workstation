<div class="sectores view">
<h2><?php echo __('Sectore'); ?></h2>
	<dl>
		<dt><?php echo __('Id'); ?></dt>
		<dd>
			<?php echo h($sectore['Sectore']['id']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Designacao'); ?></dt>
		<dd>
			<?php echo h($sectore['Sectore']['designacao']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Delegacao'); ?></dt>
		<dd>
			<?php echo $this->Html->link($sectore['Delegacao']['id'], array('controller' => 'delegacaos', 'action' => 'view', $sectore['Delegacao']['id'])); ?>
			&nbsp;
		</dd>
	</dl>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('Edit Sectore'), array('action' => 'edit', $sectore['Sectore']['id'])); ?> </li>
		<li><?php echo $this->Form->postLink(__('Delete Sectore'), array('action' => 'delete', $sectore['Sectore']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $sectore['Sectore']['id']))); ?> </li>
		<li><?php echo $this->Html->link(__('List Sectores'), array('action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Sectore'), array('action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Delegacaos'), array('controller' => 'delegacaos', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Delegacao'), array('controller' => 'delegacaos', 'action' => 'add')); ?> </li>
	</ul>
</div>
